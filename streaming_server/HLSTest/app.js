const app = require('express')();
const fs = require('fs');
const hls = require('hls-server');

app.get('/',(req, res) => {
    return res.status(200).sendFile(`${__dirname}/client.html`);
});

const server = app.listen(3000);

new hls(server, {
    provider:{
        exists: (req, cb) =>  //exists: 모든 요청에 대해 실행 -> 파일이 존재하는지 확인하기 위함 콜백에 null, false 를 넘기면 파일이 존재하지 않는다는 뜻입니다.
        {
            const ext = req.url.split('.').pop();

            if (ext !== 'm3u8' && ext !== 'ts')
            {
                return cb(null, true);
            }

            fs.access(__dirname + req.url, fs.constants.F_OK, function(err){
                if(err){
                    console.log('File not exist');
                    return cb(null,false);
                }
                cb(null, true);
            });
        },
        getManifestStream: (req, cb) => // .m3u8 파일에 대한 요청일 때 실행하고 콜백에 null과 stream을 넘겨준다.
        {
            console.log('getManifest : ', __dirname + req.url);
            const stream = fs.createReadStream(__dirname + req.url);
            cb(null, stream);
        },
        getSegmentStream: (req, cb) => // .ts파일에 대한 요청일 때 실행하고 콜백에 null과 stream을 넘겨준다.
        {
            console.log('getSegmentStream : ', __dirname + req.url);
            const stream = fs.createReadStream(__dirname + req.url);
            cb(null, stream);
        }
    }
});