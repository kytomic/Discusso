import React, { useEffect } from 'react';
import { Box } from '@mui/material';
import Socket from '../service/Socket';
import NavBar from '../component/NavBar';
import ChatBar from '../component/ChatBar';
import ChatRoom from '../component/ChatRoom';

const Main = () => {
  useEffect(() => {
    Socket.register();
  }, [])

  return (
    <Box className='main' id='main'>
        <NavBar />
        <ChatBar />
        <ChatRoom />
    </Box>
  )
}

export default Main;