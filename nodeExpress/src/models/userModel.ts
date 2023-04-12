import { Schema, model } from 'mongoose';

const userSchema = new Schema(
  {
    user_first_name: {
      required: true,
      type: String,
    },
    user_last_name: {
      required: true,
      type: String,
    },
    user_birth: {
      required: true,
      type: Date,
    },
    user_country: {
      required: true,
      type: String,
    },
  },
  {
    timestamps: true,
  }
);

export default model('User', userSchema);
