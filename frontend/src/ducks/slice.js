import { createSlice } from '@reduxjs/toolkit';
// import axios from 'axios';

export const loginStatusSlice = createSlice({
  name: 'loginStatusSlice',
  initialState: {status: false},
  reducers: {
    login: (state, action) => {state.status = true},
    logout: (state, action) => {state.status = false},
  }
});
export const loginUserInfoSlice = createSlice({
  name: 'loginUserInfoSlice',
  initialState: {loginUserInfo: {}},
  reducers: {
    getLoginUser: (state, action) => {state.loginUserInfo = action.payload},
  }
  // redux thunk는 나중에 써보는 걸로...
  // extraReducers: (builder) => {
  //   builder.addCase(asyncUserInfo.fulfilled, (state, action) => {
  //     state.loginUserInfo = action.payload;
  //   })
  // }
});

// export const asyncUserInfo = createAsyncThunk(
//   'loginUserInfoSlice/asyncUserInfo',
//   async (data) => {
//     return await axios({
//       method: 'get',
//       url: process.env.REACT_APP_SERVER_URL,
//       params: {
//         username: data.email,
//         password: data.password,
//       },
//     });
//   }
// );