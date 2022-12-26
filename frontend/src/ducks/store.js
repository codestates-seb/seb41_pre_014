import { configureStore } from '@reduxjs/toolkit';
import { loginStatusSlice } from './slice';

export const store = configureStore({
  reducer: {
    loginStatus: loginStatusSlice.reducer,
  }
})