import { Suspense, useEffect} from 'react';
import { Routes, Route } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { LoadingIndicator } from '../components/blocks/LoadingIndicator';
import { getCookie } from '../modules/Cookies';
import { loginStatusSlice, loginUserInfoSlice } from '../ducks/slice';

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
  UserDetail,
  UserProfile,
  UserActivity,
  ActivityQuestions,
  ActivityAnswers,
  ActivityFollowing,
  ActivityVotes,
  UserSettings,
  Write,
  NotFound,
} from '../pages';

export const Router = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    if (localStorage.getItem('loginUserInfo') && getCookie('accessJwtToken')) {
      dispatch(loginUserInfoSlice.actions.getLoginUser(JSON.parse(localStorage.getItem('loginUserInfo'))));
      dispatch(loginStatusSlice.actions.login());
    };
  }, []);

  const loginStatus = useSelector(state => state.loginStatus.status);

  return (
    <>
      <Suspense fallback={<LoadingIndicator />}>
        <Routes>
          <Route path='/' element={loginStatus ? <HomeLoginBoard /> : loginStatus ? <HomeLoginBoard /> : <Home />}></Route>

          <Route path='/users' element={<Users />}></Route>
          <Route path='/users/login' element={<Login />}></Route>
          <Route path='/users/logout' element={<LogOut />}></Route>
          <Route path='/users/signup' element={<SignUp />}></Route>
          <Route path='/users/:userId' element={<UserDetail />}>
            <Route index element={<UserProfile />} />
            <Route path="profile" element={<UserProfile />} />
            <Route path="activity" element={<UserActivity />}>
              <Route index element={<ActivityAnswers />} />
              <Route path="questions" element={<ActivityQuestions />} />
              <Route path="answers" element={<ActivityAnswers />} />
              {/* <Route path="tags" element={<ActivityTags />} /> */}
              <Route path="following" element={<ActivityFollowing />} />
              <Route path="votes" element={<ActivityVotes />} />
            </Route>
            <Route path="settings" element={<UserSettings />} />
            <Route/>
          </Route>

          <Route path='/questions' element={<QuestionBoard />}></Route>
          <Route path='/questions/ask' element={<Write />}></Route>
          <Route path='/questions/:detailId' element={<Detail />}></Route>

          <Route path='/posts/:detailId/edit' element={<QuestionEdit />}></Route>
          <Route path='/posts/:detailId/answer/edit' element={<AnswerEdit />}></Route>
          <Route path='/posts/:detailId/editrequest' element={<EditRequest />}></Route>

          <Route path='*' element={<NotFound />}></Route>
        </Routes>
      </Suspense>
    </>
  )
}