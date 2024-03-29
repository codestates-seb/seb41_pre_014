import { lazy } from "react";

export const HomeLoginBoard = lazy(() => import('./HomeLoginBoard'));
export const QuestionBoard = lazy(() => import('./QuestionBoard'));
export const SearchBoard = lazy(() => import('./SearchBoard'));
export const Detail = lazy(() => import('./Detail'));
export const QuestionEdit = lazy(() => import('./QuestionEdit'));
export const AnswerEdit = lazy(() => import('./AnswerEdit'));
export const EditRequest = lazy(() => import('./EditRequest'));
export const Write = lazy(() => import('./Write'));

export const Home = lazy(() => import('./Home'));
export const Login = lazy(() => import('./Login'));
export const LogOut = lazy(() => import('./LogOut'))
export const SignUp = lazy(() => import('./SignUp'));

export const Users = lazy(() => import('./Users'));
export const UserDetail = lazy(() => import('./UserDetail'));
export const UserProfile = lazy(() => import('./UserProfile'));
export const UserActivity = lazy(() => import('./UserActivity'));
export const ActivityQuestions = lazy(() => import('./ActivityQuestions'));
export const ActivityAnswers = lazy(() => import('./ActivityAnswers'));
export const ActivityTags = lazy(() => import('./ActivityTags'));
export const ActivityFollowing = lazy(() => import('./ActivityFollowing'));
export const ActivityVotes = lazy(() => import('./ActivityVotes'));
export const UserSettings = lazy(() => import('./UserSettings'));

export const NotFound = lazy(() => import('./NotFound'));