import React from 'react';
import { Box, Avatar, Typography } from '@mui/material';
import './style/chatBlock.css';

const ChatBlock = () => {
  return (
    <Box className='chatBlock'>
      <Avatar className='avatar'>K</Avatar>
      <Box className='chatBlockContent'>
        <Box className='upperChatBlockContent'>
          <Typography className='chatName'>Name</Typography>
          <Typography className='chatTime'>11:45 am</Typography>
        </Box>
        <Typography className='chatMsg'>Last Message</Typography>
      </Box>
    </Box>
  )
}

export default ChatBlock;