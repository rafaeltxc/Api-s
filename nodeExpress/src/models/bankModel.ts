import { Schema, model } from 'mongoose';

const bankSchema = new Schema(
  {
    bank_name: {
      require: true,
      type: String,
    },
  },
  {
    timestamps: true,
  }
);

export default model('Bank', bankSchema);
