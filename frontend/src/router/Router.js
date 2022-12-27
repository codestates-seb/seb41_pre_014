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
  UserActivity,
  ActivityQuestions,
  ActivityAnswers,
  ActivityTags,
  ActivityFollowing,
  ActivityVotes,
  Write,
  NotFound
} from '../pages';

export const Router = () => {
  const loginStatus = useSelector(state => state.loginStatus.status)

  return (
    <>
      <Suspense fallback={<div>loading...</div>}>
        <Routes>
          <Route path='/' element={loginStatus ? <HomeLoginBoard /> : <Home />}></Route>

          <Route path='/users' element={<Users />}></Route>
          <Route path='/users/login' element={<Login />}></Route>
          <Route path='/users/logout' element={<LogOut />}></Route>
          <Route path='/users/signup' element={<SignUp />}></Route>
          {/* UserDetail로 수정되어야 함 */}
          <Route path='/users/:userId' element={<Users />}>
            <Route index element={<UserActivity />} />
            <Route path="profile" element={<UserActivity />} />
            <Route path="activity" element={<UserActivity />}>
              <Route index element={<ActivityQuestions />} />
              <Route path="questions" element={<ActivityQuestions />} />
              <Route path="answers" element={<ActivityAnswers />} />
              <Route path="tags" element={<ActivityTags />} />
              <Route path="following" element={<ActivityFollowing />} />
              {/* <Route path="reputation" element={<UserActivity />} /> */}
              <Route path="votes" element={<ActivityVotes />} />
            </Route>
            <Route path="settings" element={<UserActivity />} />
          </Route>

          <Route path='/questions' element={<QuestionBoard />}></Route>
          <Route path='/questions/ask' element={<Write />}></Route>
          <Route path='/questions/:detailId' element={<Detail />}></Route>

          <Route path='/posts/:detailId/edit' element={<QuestionEdit />}></Route>
          {/* answer에도 고유한 Id값이 있어야 겠는데? */}
          <Route path='/posts/:detailId' element={<AnswerEdit />}></Route>
          <Route path='/posts/:detailId/editrequest' element={<EditRequest />}></Route>
          
          <Route path='temporary' element={<UserActivity />}></Route>
          <Route path='*' element={<NotFound />}></Route>
        </Routes>
      </Suspense>
    </>
  )
}