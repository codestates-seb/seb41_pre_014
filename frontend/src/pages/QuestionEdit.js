import styled from "styled-components";
import { Input } from '../components/atoms/Input';
import { Button } from '../components/atoms/Button';
import { MainRightSideInfoWidget } from "../components/blocks/MainRight";
import { InputLabel, EditorInput } from "../components/blocks/EditorInputWrapper";
import { EditSideInfoWidgetData } from "../data/staticData/SideBarData";

const Main = styled.div`
  display: flex;
`;

const MainLeft = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1.5rem;

  .buttonWrapper {
    display: flex;
    flex-direction: row;
    gap: 0.8rem;
    margin-top: 1.5rem;
  }

  > div {
    display: flex;
    flex-direction: column;
    gap: 0.4rem;
  }
`;

const MainRight = styled.div`
  padding-left: 2.4rem;
`;

const QuestionEdit = (props) => {
  return (
    <>
        <Main>
          <MainLeft>
            <div>
              <InputLabel 
                title='Title'
              />
              <Input
                placeholder={props.title}
                padding='0.78rem 0.91rem'
                width='100%'
                />
            </div>
            <div>
              <InputLabel 
                title='Body'
              />
              <EditorInput />
              <div>{props.questionContent}</div>
            </div>
            <div>
              <InputLabel 
                title='Tags'
              />
              <Input
              // tagblock
                placeholder={props.tags}
                padding='0.78rem 0.91rem'
                width='100%'
                />
            </div>
            <div>
              <InputLabel 
                title='Edit Summary'
              />
              {/* data-min-length="10" data-max-length="300"  */}
              <Input
                placeholder='briefly explain your changes (corrected spelling, fixed grammar, improved formatting)'
                padding='0.78rem 0.91rem'
                width='100%'
                />
            </div>
            <div className="buttonWrapper">
              <Button 
                buttonType='type2'
                buttonName='Save edits'
                width='8.04rem'
                height='3.79rem'
              />
              <Button 
                buttonType='type4'
                buttonName='Cancel'
                width='6.07rem'
                height='3.79rem'
              />
            </div>
          </MainLeft>
          <MainRight>
            {EditSideInfoWidgetData.map((el) => {
              return (
                <MainRightSideInfoWidget 
                  title={el.title}
                  contents={el.contents} 
                />
              )
            })}            
          </MainRight>
        </Main>
    </>
  )
};

export default QuestionEdit;