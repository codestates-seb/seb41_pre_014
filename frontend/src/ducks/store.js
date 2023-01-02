import { configureStore } from '@reduxjs/toolkit';
import { loginStatusSlice, loginUserInfoSlice } from './slice';

export const store = configureStore({
  reducer: {
    loginStatus: loginStatusSlice.reducer,
    loginUserInfo: loginUserInfoSlice.reducer,
  }
})