import { createSlice } from '@reduxjs/toolkit';

export const loginStatusSlice = createSlice({
  name: 'loginStatusSlice',
  initialState: {status: false},
  reducers: {
    login: (state, action) => {state.status = true},
    logout: (state, action) => {state.status = false},
  }
});

// export const loginUserInfoSlice = createSlice({
//   name: 'loginUserInfoSlice',
//   initialState: {},
//   reducers: {
//     userInfoRead: (state, action) => {state = action.payload},
//   }
// })