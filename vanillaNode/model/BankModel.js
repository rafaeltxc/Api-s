const { db } = require("../connection");

function getAll() {
  const query = "SELECT * FROM tbl_bank;";
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
  const query = `SELECT * FROM tbl_bank WHERE bank_id = ${id}`;
  return new Promise((resolve, reject) => {
    db.query(query, (err, rows) => {
      if (err) {
        reject(err);
      }
      resolve(rows);
    });
  });
}

function update(bankName, id) {
  const query = `UPDATE tbl_bank SET bank_name = '${bankName}' WHERE bank_id = ${id}`;
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
  const query = `DELETE FROM tbl_bank WHERE bank_id = ${id}`;
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

function insert(bankName) {
  const query = `INSERT INTO tbl_bank (bank_name) VALUES ('${bankName}')`;
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
