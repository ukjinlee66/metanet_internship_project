const ffmpeg = require('fluent-ffmpeg');

const ffmpegInstaller = require('@ffmpeg-installer/ffmpeg');

//ffmpegInstaller는 ffmpeg만 사용했을 때 생겼던 오류를 해결하기 위해 사용.
ffmpeg.setFfmpegPath(ffmpegInstaller.path);

ffmpeg('일식집호프집에서먹던그콘치즈만들기_CornCheese.mp4', {timeout : 432000}).addOptions([
    '-profile:v baseline',
    '-level 3.0',
    '-start_number 0',
    '-hls_time 10', // hls_time : 몇 초 단위로 동영상을 분할할 것인지 설정
    '-hls_list_size 0',
    '-f hls' // 포맷을 설정 -> HLS사용.
]).output('일식집호프집에서먹던그콘치즈만들기_CornCheese.m3u8').on('end',() =>{
    console.log('end');
}).run();