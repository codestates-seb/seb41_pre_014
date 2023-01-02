import styled from "styled-components";
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import { forwardRef, useState } from "react";

const InputLabelWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  text-align: left;
  background-color: #ffffff;

  & .title {
    color: #0c0d0e;
    font-size: 1.5rem;
    font-weight: 600;
    padding: 0.2rem;
  }

  & .label {
    color: #3b4045;
    font-size: 1.2rem;
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


const StyledEditorInput = styled.div`
  border-radius:0.4rem;
  &.active {
    outline: 0.1rem solid #379fef;
    box-shadow: 0 0 0.5rem #b3d3ea;
  }
`;

export const EditorInput = forwardRef((props, ref) => {
  const [ inputActive, setInputActive ] = useState(false);

  return (
    <StyledEditorInput className={inputActive ? 'active' : null}>
      <Editor 
        previewStyle='vertical'
        height='30rem'
        toolbarItems={props.toolbarItems || [
          ['heading', 'bold', 'italic', 'strike'],
          ['hr', 'quote'],
          ['ul', 'ol', 'task', 'indent', 'outdent'],
          ['table', 'image', 'link'],
          ['code', 'codeblock']
        ]}
        ref={ref}
        onFocus={() => setInputActive(true)}
        onBlur={() => setInputActive(false)}
      />
    </StyledEditorInput>
  )
});

export const EditorInputWrapper = forwardRef((props, ref) => {
  return (
    <>
      <InputLabel title={props.title} label={props.label} />
      <EditorInput ref={ref} />
    </>
  )
});