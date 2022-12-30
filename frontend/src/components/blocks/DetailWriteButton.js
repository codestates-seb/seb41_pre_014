import { Button } from "../atoms/Button";
import { useNavigate } from "react-router-dom";

export const DetailWriteButton = () => {
  const navigate = useNavigate();
  const ButtonClick = () => {
    navigate('/questions/ask');
  }

  return (
    <Button 
    buttonType='type2' 
    buttonName='Ask Question'
    onClick={ButtonClick}
    width='9.87rem'
    height='3.78rem'
    />
  )
}