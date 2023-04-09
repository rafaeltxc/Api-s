const { db } = require("../connection");

function getAll() {
  const query = "SELECT * FROM tbl_account;";
  return new Promise((resolve, reject) => {
    db.query(query, (err, rows) => {
      if (err) {
        reject(err);
      }
      resolve(rows);
    });
  });
}

function getById(id) {
  const query = `SELECT * FROM tbl_account WHERE account_id = ${id}`;
  return new Promise((resolve, reject) => {
    db.query(query, (err, rows) => {
      if (err) {
        reject(err);
      }
      resolve(rows);
    });
  });
}

function update(accountTotalMoney, id) {
  const query = `UPDATE tbl_account SET account_total_money = ${accountTotalMoney} WHERE account_id = ${id}`;
  try {
    db.query(query, (err) => {
      if (err) {
        throw err;
      } else {
        db.commit();
      }
    });
  } catch (err) {
    new Error(err);
  }
}

function deletetion(id) {
  const query = `DELETE FROM tbl_account WHERE account_id = ${id}`;
  try {
    db.query(query, (err) => {
      if (err) {
        throw err;
      } else {
        db.commit();
      }
    });
  } catch (err) {
    new Error(err);
  }
}

function insert(accountTotalMoney, fkUser, fkBank) {
  let pad = function (num) {
    return ("00" + num).slice(-2);
  };
  let date;
  date = new Date();
  date =
    date.getUTCFullYear() +
    "-" +
    pad(date.getUTCMonth() + 1) +
    "-" +
    pad(date.getUTCDate());

  const query = `INSERT INTO tbl_account (account_total_money, account_creation_date, fk_tbl_user_tbl_account, fk_tbl_bank_tbl_account) VALUES ('${accountTotalMoney}', '${date}', '${fkUser}', '${fkBank}')`;
  try {
    db.query(query, (err) => {
      if (err) {
        throw err;
      } else {
        db.commit();
      }
    });
  } catch (err) {
    new Error(err);
  }
}

module.exports = {
  getAll,
  getById,
  update,
  deletetion,
  insert,
};
