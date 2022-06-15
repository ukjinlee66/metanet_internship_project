import { useEffect, useRef, useState } from "react";

export default function VideoHover(props) {
  const ref = useRef(null);
  const [focus, setFocus] = useState(false);

  const loop = () => {
    ref.current.play();
  };

  const onEndedLoop = () => {
    if (focus) loop(); // when ended check if its focused then loop
  };

  const pauseLoop = () => {
    ref.current.pause();
  };

  useEffect(() => {
    if (focus) loop(); // when focused then loop
    if (!focus) pauseLoop();
  }, [focus]);

  return (
    <div>
      <video
        id="video"
        ref={ref}
        style={{ width: "200px" ,height: "200px"}}
        onMouseOver={() => setFocus(true)}
        onMouseOut={() => setFocus(false)}
        muted={true}
        src={props.name}
        onEnded={onEndedLoop}
        type="video/mp4"
      ></video>
    </div>
  );
}