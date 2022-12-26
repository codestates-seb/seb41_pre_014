import { createSlice } from '@reduxjs/toolkit';

export const loginStatusSlice = createSlice({
  name: 'loginStatusSlice',
  initialState: {status: false},
  reducers: {
    login: (state, action) => {state.status = true},
    logout: (state, action) => {state.status = false},
  }
})