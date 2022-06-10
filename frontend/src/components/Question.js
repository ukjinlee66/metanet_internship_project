import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../assets/css/bootstrap.min.css';
import '../assets/css/style.css';
import axios from "axios";
import ReactDOM from "react-dom";
// import FAQ from "./FAQ";
import Faq from "./FAQ";

function Question() {
  const [rows, setRowsOption] = useState(null);
  const data = {
    title: "FAQ (How it works)",
    rows: [
      {
        title: "Lorem ipsum dolor sit amet,",
        content: `Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed tempor sem. Aenean vel turpis feugiat,
              ultricies metus at, consequat velit. Curabitur est nibh, varius in tellus nec, mattis pulvinar metus.
              In maximus cursus lorem, nec laoreet velit eleifend vel. Ut aliquet mauris tortor, sed egestas libero interdum vitae.
              Fusce sed commodo purus, at tempus turpis.`
      },
      {
        title: "Nunc maximus, magna at ultricies elementum",
        content:
          "Nunc maximus, magna at ultricies elementum, risus turpis vulputate quam, vitae convallis ex tortor sed dolor."
      },
      {
        title: "Curabitur laoreet, mauris vel blandit fringilla",
        content: `Curabitur laoreet, mauris vel blandit fringilla, leo elit rhoncus nunc, ac sagittis leo elit vel lorem.
            Fusce tempor lacus ut libero posuere viverra. Nunc velit dolor, tincidunt at varius vel, laoreet vel quam.
            Sed dolor urna, lobortis in arcu auctor, tincidunt mattis ante. Vivamus venenatis ultricies nibh in volutpat.
            Cras eu metus quis leo vestibulum feugiat nec sagittis lacus.Mauris vulputate arcu sed massa euismod dignissim. `
      },
      {
        title: "What is the package version",
        content: <p>current version is 1.2.1</p>
      }
    ]
  };
  // useEffect(() => {
  //     if (rows) {
  //         setTimeout(() => {
  //             rows[0].expand();
  //         }, 2500);

  //         setTimeout(() => {
  //             rows[0].close();
  //         }, 5000);

  //         setTimeout(() => {
  //             rows[0].scrollIntoView();
  //             // rows[0].scrollIntoView(true);
  //         }, 10000);
  //     }
  // }, [rows]);

  return (
    <div>
      <h2 className="section-title">FAQ section</h2>

      <div className="faq-style-wrapper">
        <Faq data={data} getRowOptions={setRowsOption} />
      </div>
    </div>
  );
}

const rootElement = document.getElementById("root");
ReactDOM.render(<Question />, rootElement);

export default Question;