import { Editor } from "@tinymce/tinymce-react";

// type Props = {
//   handleEditorChange: () => void;
//   description: string;
// };
const Work = () => {
  return (
    <Editor
      apiKey="bjvro15xzp578awed76jjd439yuuldwig8ojluroj18stkik" // Bạn có thể đăng ký và nhận API key từ https://www.tiny.cloud/
      init={{
        height: 400,
        menubar: false,
        plugins: [
          "advlist autolink lists link image charmap print preview anchor",
          "searchreplace visualblocks code fullscreen",
          "insertdatetime media table paste code help wordcount",
        ],
        toolbar:
          "undo redo | formatselect | bold italic backcolor | \
          alignleft aligncenter alignright alignjustify | \
          bullist numlist outdent indent | removeformat | help",
      }}
    />
  );
};

export default Work;
