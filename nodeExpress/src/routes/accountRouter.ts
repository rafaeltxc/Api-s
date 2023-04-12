/* eslint-disable import/extensions */
/* eslint-disable import/no-unresolved */
import { Router } from 'express';
import AccountController from '../controllers/accountController';

const router = Router();

router.get('/', AccountController.find);
router.get('/:id', AccountController.find);
router.post('/', AccountController.post);
router.put('/:id', AccountController.update);
router.delete('/:id', AccountController.deleteOne);

export default router;
