const { Router } = require("express");
const ffmpeg = require("fluent-ffmpeg");

Router.post("/thumbnail", (req, res) => {
    //썸네일 생성 하고 비디오 러닝타임도 가져오는 api

    let fileDuration = "";
    let filePath = "/videos/고등어조림.mp4";
    
    //비디오 정보 가져오기
    ffmpeg.ffprobe(req.body.url, function (err, metadata)
    {
        //url을 받으면 해당 비디오에 대한 정보가 metadata에 담긴다.
        console.log(metadata); // metadata안에 담기는 모든 정보들 체킹
        fileDuration = metadata.format.duration; // 동영상 길이 대입
    });
    //썸네일 생성
    ffmpeg(req.body.url) // 클라이언트에서 보낸 비디오 저장 경로
        .on("filenames", function (filenames){
            //해당 url에 있는 동영상을 밑에 스크린샷옵션을 기반으로
            //캡처한 후 filenames라는 이름에 파일이름들을 저장
            console.log("will generate " + filenames.join(","));
            console.log("filenames:",filenames);

            filePath = "videos/thumbnails/" + filenames[0];
        })
        .on("end", function(){
            console.log("Screenshots taken");
            return res.json({
                success: true,
                url: filePath,
                fileDuration: fileDuration
            });
            //fileDuration : 비디오 러닝타임
        })
        .on("error", function(err){
            console.log(err);
            return res.json({success: false, err});
        })
        .screenshot({
            //Will take screenshots at 20% 40% 60% and 80% of the video
            count: 3,
            folder: "videos/thumbnails",
            size: "320x240",
            //'%b' : input basename(filename w/o extension) = 확장자제외 파일명
            filename: "thumbnail-%b.png",
        });
});