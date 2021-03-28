# 簡易的聊天 Chat Room
## 功能
1. 聊天訊息內容列表如果超過一頁，可以上下滑動。
2. 訊息從下方開始呈現，由最新的訊息開始。
3. 固定位置的輸入列，中間區塊為 EditTextView 。
4. 在下方 Input box 的左邊加一顆 button，模擬收到的訊息；右邊為正常的訊息送出按鈕。
5. 將對話紀錄存成 chat_record.txt
## 未來展望
1. 將發送端和接收端的訊息內容用適當的 data model 存入 local 的 database 中。下次再開啟 App 時，從 database 中再把既有的訊息內容呈現出來。
2. 整合 Firebase，實作登入功能，和儲存訊息的功能。
## 開發環境
- 使用 Eclipse IDE for Java Developers

![image](https://github.com/lindaya0913/chat-application/blob/main/chat_room.PNG)