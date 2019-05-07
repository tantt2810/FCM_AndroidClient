# FCM_AndroidClient
Implement FCM on android client
# Result
![alt text](https://github.com/tantt2810/FCM_AndroidClient/blob/master/result_images/register_token.png)

Then post request to FCM Server via the legacy HTTP protocol:
```
curl -X POST -H "Authorization: key=<YOUR_SERVER_KEY>" \
   -H "Content-Type: application/json" \
   -d '{
  "data": {
    "content": "You Have a Notification Message"
  },
  "to": "<YOUR_DEVICE_REGISTER_TOKEN>"
}' https://fcm.googleapis.com/fcm/send
```

![alt text](https://github.com/tantt2810/FCM_AndroidClient/blob/master/result_images/receive_message.png)
