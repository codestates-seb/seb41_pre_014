import { Suspense } from 'react';
import { Routes, Route } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { 
  HomeLoginBoard,
  QuestionBoard,
  Detail,
  QuestionEdit,
  AnswerEdit,
  EditRequest,
  Home,
  Login,
  LogOut,
  SignUp,
  Users,
  Write,
  NotFound
} from '../pages';


export const Router = () => {
  const loginStatus = useSelector(state => state.loginStatus.status)

  return (
    <>
      <Suspense fallback={<div>loading...</div>}>
        <Routes>
          <Route path='/' element={<Home />}></Route>

          <Route path='/users' element={<Users />}></Route>
          <Route path='/users/login' element={<Login />}></Route>
          <Route path='/users/logout' element={<LogOut />}></Route>
          <Route path='/users/signup' element={<SignUp />}></Route>
          {/* UserDetail로 수정되어야 함 */}
          <Route path='/users/:userId' element={<Detail />}></Route>

          <Route path='/questions' element={<QuestionBoard />}></Route>
          <Route path='/questions/ask' element={<Write />}></Route>
          <Route path='/questions/:detailId' element={<Detail />}></Route>

          <Route path='/editrequest' element={<EditRequest />}></Route>
          
          <Route path='*' element={<NotFound />}></Route>
        </Routes>
      </Suspense>
    </>
  )
}