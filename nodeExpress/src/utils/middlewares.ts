import { NextFunction, Request, Response } from 'express';

function errorHandler(error: any, request: Request, response: Response, next: NextFunction) {
  console.log(error.name);

  switch (error.name) {
    case '':
      break;
    default:
      response.status(500).json({ Error: error.message });
      break;
  }

  next(error);
}

function unknownEndpoint(request: Request, response: Response, next: NextFunction) {
  try {
    response.status(404).json({ Error: 'Unknown endpoint' });
    next();
  } catch (error) {
    next(error);
  }
}

export default {
  errorHandler,
  unknownEndpoint,
};
