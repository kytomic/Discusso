import { useRef } from 'react';
import { over } from 'stompjs';
import SockJS from 'sockjs-client';

class Socket {
    static register = () => {
        let sock = new SockJS('http://localhost:3000/ws');
        this.stompClientRef = over(sock);
        this.stompClientRef.connect({}, this.Connect, this.PrintError);
    }

    static connect = () => {
        this.stompClientRef.subscribe('/chat', async (res) => {
            console.log(JSON.parse(res.body));
        });
    }

    static printError = (err) => {
        console.log('Error with websocket', err);
    }
}

export default Socket;