/* eslint-disable import/extensions */
/* eslint-disable import/no-unresolved */
import { Router } from 'express';
import BankController from '../controllers/bankController';

const router = Router();

router.get('/', BankController.find);
router.get('/:id', BankController.find);
router.post('/', BankController.post);
router.put('/:id', BankController.update);
router.delete('/:id', BankController.deleteOne);

export default router;
