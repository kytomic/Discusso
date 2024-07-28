import { Avatar, Box, Paper, InputBase, IconButton, Typography } from '@mui/material'
import React from 'react'
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import './style/chatRoom.css';
import Message from './Message';

const ChatRoom = () => {
  return (
    <Box className='chatroom'>
        <Box className='header'>
            <Avatar className='avatar'>K</Avatar>
            <Typography className='chatName'>Ken</Typography>
        </Box>
        <Box className='messageList'>
            <Message />
            <Message />
            <Message />
        </Box>
        <Box className='chatInputBox'>
            <Paper className='inputPaper'>
                <InputBase className='inputField'/>
            </Paper>
            <IconButton>
                <ArrowForwardIcon/>
            </IconButton>
        </Box>
    </Box>
  )
}

export default ChatRoom