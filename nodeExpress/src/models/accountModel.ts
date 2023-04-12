import { Schema, model } from 'mongoose';

const accountSchema = new Schema(
  {
    account_total_money: {
      required: true,
      type: Number,
    },
    fk_user: {
      required: true,
      type: Schema.Types.ObjectId,
      ref: 'User',
    },
    fk_bank: {
      required: true,
      type: Schema.Types.ObjectId,
      ref: 'Bank',
    },
  },
  {
    timestamps: true,
  }
);

export default model('Account', accountSchema);
