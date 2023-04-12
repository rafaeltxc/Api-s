/* eslint-disable import/extensions */
/* eslint-disable import/no-unresolved */
import { NextFunction, Request, Response } from 'express';
import BankModel from '../models/bankModel';

async function find(request: Request, response: Response, next: NextFunction) {
  if (!request.params.id) {
    try {
      const data = await BankModel.find();
      response.status(200).json(data);
    } catch (error) {
      next(error);
    }
  } else {
    try {
      const data = await BankModel.findById(request.params.id);
      response.status(200).json(data);
    } catch (error) {
      next(error);
    }
  }
}

async function post(request: Request, response: Response, next: NextFunction) {
  try {
    const obj = new BankModel(request.body);
    const data = await obj.save();
    response.status(200).json(data);
  } catch (error) {
    next(error);
  }
}

async function update(request: Request, response: Response, next: NextFunction) {
  try {
    await BankModel.findOneAndUpdate({ _id: request.params.id }, request.body, { new: true });
    response.status(204).end();
  } catch (error) {
    next(error);
  }
}

async function deleteOne(request: Request, response: Response, next: NextFunction) {
  try {
    await BankModel.deleteOne({ _id: request.params.id });
    response.status(204).end();
  } catch (error) {
    next(error);
  }
}

export default {
  find,
  post,
  update,
  deleteOne,
};
