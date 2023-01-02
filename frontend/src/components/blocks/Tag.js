import { useState, forwardRef } from "react";
import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faX } from "@fortawesome/free-solid-svg-icons";

// TODO: Styled-Component 라이브러리를 활용해 여러분만의 tag 를 자유롭게 꾸며 보세요!

export const TagsInput = styled.div`
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  min-height: 48px;
  width: 100%;
  padding: 0.78rem 0.91rem;
  border: 1px solid rgb(214, 216, 218);
  border-radius: 6px;
  > ul {
    display: flex;
    flex-wrap: wrap;
    > .tag {
      width: auto;
      display: flex;
      align-items: center;
      justify-content: center;
      color: #000;
      padding: 0.8rem;
      list-style: none;
      border-radius: 6px;
      margin-right: 0.5rem;
      background: #E1ECF4;
      >.tag-title {
        font-size: 1.3rem;
      }

      >.tag-close-icon {
        display: block;
        width: 16px;
        height: 16px;
        line-height: 16px;
        text-align: center;
        font-size: 14px;
        margin-left: 8px;
        color: var(--coz-purple-600);
        border-radius: 50%;
        background: #fff;
        cursor: pointer;
      }
    }
  }
  > input {
    flex: 1;
    width:100%;
    border: none;
    font-size: 1.3rem;
    :focus {
      outline: transparent;
    }
  }
  &:focus-within {
    outline: 0.1rem solid #379fef;
    box-shadow: 0 0 0.5rem #b3d3ea;
  }
`;

export const Tag = forwardRef((props, ref) => {
  
  const removeTags = (index) => {
    props.setTags([...props.tags.slice(0, index), ...props.tags.slice(index + 1)]);
  };

  const addTags = (e) => {
    const inputValue = e.target.value.includes(',') || e.target.value.includes(' ') 
      ? e.target.value.slice(0, -1) 
      : e.target.value;

    if (!props.tags.includes(inputValue) && inputValue !== "") {
      props.setTags([...props.tags, inputValue]);
      e.target.value = "";
    }
  };

  return (
    <>
      <TagsInput>
        <ul id="tags">
          {props.tags.map((tag, index) => (
            <li key={index} className="tag">
              <span className="tag-title">{tag}</span>
              <span
                className="tag-close-icon"
                onClick={() => {
                  removeTags(index);
                }}
              >
                <FontAwesomeIcon icon={faX} />
              </span>
            </li>
          ))}
        </ul>
        <input
          className="tag-input"
          type="text"
          onKeyUp={(e) => {
            if (['Enter', 'Space', 'Comma'].includes(e.code)) {
              addTags(e);
            }
          }}
          placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
          ref={ref}
        />
      </TagsInput>
    </>
  );
});