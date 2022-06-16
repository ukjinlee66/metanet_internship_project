import React, {useCallback} from 'react';
import '../views/sign.css';
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import { UploadOutlined } from '@ant-design/icons';
import { Form, Input, Button, Checkbox, Upload } from 'antd';

const props = {
    action: '//jsonplaceholder.typicode.com/posts/',
    listType: 'picture',
  
    previewFile(file) {
      console.log('Your upload file:', file); // Your process logic. Here we just mock to the same file
  
      return fetch('https://next.json-generator.com/api/json/get/4ytyBoLK8', {
        method: 'POST',
        body: file,
      })
        .then((res) => res.json())
        .then(({ thumbnail }) => thumbnail);
    },
};

function CreateRecipe() 
{
    const getBase64 = (img, callback) => {
        const reader = new FileReader();
        reader.addEventListener('load', () => callback(reader.result));
        reader.readAsDataURL(img);
    };
    
    const beforeUpload = (file) => {
    const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
    
    if (!isJpgOrPng) {
        alert('You can only upload JPG/PNG file!');
    }
    
    const isLt2M = file.size / 1024 / 1024 < 2;
    
    if (!isLt2M) {
        alert('Image must smaller than 2MB!');
    }
    
    return isJpgOrPng && isLt2M;
    };
  return (
    <div className="App">
      <Navbar />
      <div className="auth-wrapper">
        <div className="auth-inner" style={{width: "950px"}}>
            <Form name="basic"
                
                initialValues={{
                    remember: true,
                }}
                autoComplete="off">
                
                    <h3 style={{textAlign: "center"}}>레시피 등록</h3>
                    <Form.Item
                        label="레시피 이름 : "
                        name="username"
                        rules={[
                        {
                            required: true,
                            message: '레시피 이름을 적어주세요.',
                        },
                        ]}
                    >
                        <Input />
                    </Form.Item>
                    {/* <Input type="name" class="form-control" id="RecipeName" placeholder="Write RecipeName"/> */}
                    <div class="form-group">
                    <label for="exampleInputPassword1" class="form-label mt-4">조리시간</label>
                    <Input type="time" class="form-control" name="exampleInputPassword1" min="00:00" max="100:00" format="MM/SS"/>
                    <small id="emailHelp" class="form-text text-muted">평균적인 조리시간으로 작성해주세요.</small>
                    </div>
                    <div class="form-group">
                    <label for="exampleSelect1" class="form-label mt-4">분류</label>
                    <select class="form-select" id="exampleSelect1">
                        <option>한식</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>양식</option>
                    </select>
                    </div>
                    <div class="form-group">
                    <label for="exampleSelect2" class="form-label mt-4">난이도</label>
                    <select class="form-select" id="exampleSelect2">
                        <option>초급</option>
                        <option>중급</option>
                        <option>상급</option>
                    </select>
                    </div>
                    <div class="form-group" >
                        <label for="exampleTextarea" class="form-label mt-4">레시피 내용(조리방법)</label>
                        <textarea rows="10" class="form-control" id="exampleTextarea" placeholder="레시피 내용을 적어주세요." onkeydown="resize(this)" onkeyup="resize(this)" style={{backgroundColor: "#D8D8D8"}}></textarea>
                    </div>
                    <Upload {...props}>
                        <Button icon={<UploadOutlined />} style={{color: "#fff", backgroundColor:"#0d6efd",borderColor:"#0d6efd",display:"inline-block",fontWeight:"400",lineHeight:"1.5"}}>Upload Video(.mp4)</Button>
                    </Upload>
                    {/* <div class="form-group">
                        <label for="formFile" class="form-label mt-4">Default file input example</label>
                        <Input class="form-control" type="video/mp4" id="formFile"/>
                    </div> */}
                    
                    <Button  type="submit" class="btn btn-primary" style={{color: "#fff", backgroundColor:"#0d6efd",borderColor:"#0d6efd",display:"inline-block",fontWeight:"400",lineHeight:"1.5",marginTop:"50px",marginLeft:"500px",width:"150px"}}>등록</Button>
                    <Button  type="submit" class="btn btn-primary" style={{color: "#fff", backgroundColor:"#0d6efd",borderColor:"#0d6efd",display:"inline-block",fontWeight:"400",lineHeight:"1.5",marginTop:"50px",marginLeft:"10px",width:"150px"}}>취소</Button>
            </Form>
        </div>
      </div>
      <Footer/>
    </div>
  );
}

export default CreateRecipe;