import { Avatar, Box, Paper, InputBase, IconButton, Typography, TextField } from '@mui/material'
import React, {useState} from 'react';
import ArrowForwardIcon from '@mui/icons-material/ArrowForward';
import './style/chatRoom.css';
import Message from './Message';
import Socket from '../service/Socket';

const ChatRoom = () => {
    let [body, setBody] = useState('');

    const onSendMessage = (e) => {
        console.log('send Message');
        e.preventDefault();
        Socket.sendMessage({body, 'senderId': 1, 'receiverId': 2, 'timestamp': Date.now()});
    }

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
            <InputBase className='inputField' onChange={(e) => {setBody(e.target.value)}}/>
            <IconButton onClick={onSendMessage}>
                <ArrowForwardIcon/>
            </IconButton>
        </Box>
    </Box>
  )
}

export default ChatRoom