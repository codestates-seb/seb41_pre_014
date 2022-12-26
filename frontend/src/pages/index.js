import { lazy } from "react";

export const Board = lazy(() => import('./Board'));
export const Detail = lazy(() => import('./Detail'));
export const Edit = lazy(() => import('./Edit'));
export const EditRequest = lazy(() => import('./EditRequest'));
export const Home = lazy(() => import('./Home'));
export const Login = lazy(() => import('./Login'));
export const LogOut = lazy(() => import('./LogOut'))
export const SignUp = lazy(() => import('./SignUp'));
export const Users = lazy(() => import('./Users'));
export const Write = lazy(() => import('./Write'));

