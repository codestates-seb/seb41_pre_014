import styled from "styled-components";
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';

const InputLabelWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
  background-color: #ffffff;
  color: #3b4045;
  font-size: 1.2rem;

  &.title {
    color: #0c0d0e;
    font-size: 1.5rem;
    font-weight: 600;
    padding: 0.2rem;
  }
`;

export const InputLabel = (props) => {
  return (
    <InputLabelWrapper>
      <div className='title'>{props.title}</div>
      <div className='label'>{props.label}</div>
    </InputLabelWrapper>
  )
};


export const EditorInput = () => {
  return (
    <>
      <Editor 
        previewStyle='vertical'
        height='30rem'
        toolbarItems={[
          ['heading', 'bold', 'italic', 'strike'],
          ['hr', 'quote'],
          ['ul', 'ol', 'task', 'indent', 'outdent'],
          ['table', 'image', 'link'],
          ['code', 'codeblock']
        ]}
      />
    </>
  )
};

export const EditorInputWrapper = () => {
  return (
    <>
      <InputLabel />
      <EditorInput />
    </>
  )
};