import 'dotenv/config';
import express from 'express';

const app = express();

app.use(express.json());

console.log(process.env.PORT);
app.listen(process.env.PORT || 3030, () => {
  console.log(`Server is running on port ${process.env.PORT || 3030}`);
});
