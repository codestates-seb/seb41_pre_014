import { Suspense } from 'react';
import { Routes, Route } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { 
  Board,
  Detail,
  Edit,
  EditRequest,
  Home,
  Login,
  LogOut,
  SignUp,
  Users,
  Write
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
          <Route path='/board' element={<Board />}></Route>
          <Route path='/detail' element={<Detail />}></Route>
          <Route path='/write' element={<Write />}></Route>
          <Route path='/edit' element={<Edit />}></Route>
          <Route path='/editrequest' element={<EditRequest />}></Route>
        </Routes>
      </Suspense>
    </>
  )
}