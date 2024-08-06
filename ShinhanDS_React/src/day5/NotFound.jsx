import KeyList from 'day4/KeyList';
import MemoTest from 'day4/MemoTest';
import ReducerTest from 'day4/ReducerTest';
import ReducerTest2 from 'day4/ReducerTest2';
import SmartHome from 'day4/SmartHome';
import AppStart from 'project2/AppStart';
import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function NotFound(props) {
    return (
        <div>
            <h1>First</h1>
            {/* URL 주소에 따른 Element로 교체된다.*/}
            <BrowserRouter>
                <Routes>
                <Route path="/" element={<SmartHome/>}/>
                <Route path="/app3" element={<AppStart/>}/>
                <Route path="/reducer1" element={<ReducerTest/>}/>
                <Route path="/reducer2" element={<ReducerTest2/>}/>
                <Route path="memo" element={<MemoTest/>}/>
                <Route path="key" element={<KeyList/>}/>
                <Route path="/webboard/*" element={<webBoardHome/>}/>
                <Route path="*" element={<NotFound/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default NotFound;