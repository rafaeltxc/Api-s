/* eslint-disable import/no-unresolved */
/* eslint-disable import/extensions */
import 'dotenv/config';
import express from 'express';
import mongoose from 'mongoose';
import cors from 'cors';
import middlewares from './utils/middlewares';
import accRouter from './routes/accountRouter';
import userRouter from './routes/userRouter';
import bankRouter from './routes/bankRouter';

const app = express();

mongoose
  .connect(process.env.MONGO_URI || '')
  .then(() => {
    console.log('Connected to mongo');
  })
  .catch((error) => {
    console.log(error);
  });

mongoose.set('toJSON', {
  transform: (document, returnedObject) => {
    returnedObject.id = returnedObject._id.toString();

    delete returnedObject._id;
    delete returnedObject.__v;
  },
});

app.use(cors());
app.use(express.json());

app.use('/api/account', accRouter);
app.use('/api/user', userRouter);
app.use('/api/bank', bankRouter);

app.use(middlewares.unknownEndpoint);
app.use(middlewares.errorHandler);

const port = process.env.PORT || 3030;
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
