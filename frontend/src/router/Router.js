import { Suspense } from 'react';
import { Routes, Route } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { LoadingIndicator } from '../components/blocks/LoadingIndicator';

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
import UserSettingsDeleteProfile from '../pages/UserSettingsDeleteProfile';
import UserSettingsEditProfile from '../pages/UserSettingsEditProfile';

export const Router = () => {
  const loginStatus = useSelector(state => state.loginStatus.status)

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
            <Route path="settings" element={<UserSettings />} >
              <Route index element={<UserSettingsEditProfile/>}></Route>
              <Route path='edit' element={<UserSettingsEditProfile/>}></Route>
              <Route path='delete' element={<UserSettingsDeleteProfile/>}></Route>
            </Route>
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