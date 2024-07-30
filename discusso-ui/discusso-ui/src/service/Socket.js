import { useRef } from 'react';
import { over } from 'stompjs';
import SockJS from 'sockjs-client';

class Socket {
    static register = () => {
        let sock = new SockJS('http://localhost:3000/ws');
        this.stompClientRef = over(sock);
        this.stompClientRef.connect({}, this.connect, this.PrintError);
    }

    static connect = () => {
        this.stompClientRef.subscribe('/chat/public', async (res) => {
            console.log(res.body);
        });
    }

    static printError = (err) => {
        console.log('Error with websocket', err);
    }

    static sendMessage = (newMessage) => {
        if (this.stompClientRef && this.stompClientRef.connected)
            this.stompClientRef.send("/app/send", {}, JSON.stringify(newMessage));
        else
            console.log('WebSocket connection is not established.');
    }
}

export default Socket;