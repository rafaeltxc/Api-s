/* eslint-disable import/extensions */
/* eslint-disable import/no-unresolved */
import { Router } from 'express';
import UserController from '../controllers/userController';

const router = Router();

router.get('/', UserController.find);
router.get('/:id', UserController.find);
router.post('/', UserController.post);
router.put('/:id', UserController.update);
router.delete('/:id', UserController.deleteOne);

export default router;
