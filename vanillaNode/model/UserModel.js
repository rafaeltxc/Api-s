const { db } = require("../connection");

function getAll() {
  const query = "SELECT * FROM tbl_user;";
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
  const query = `SELECT * FROM tbl_user WHERE user_id = ${id}`;
  return new Promise((resolve, reject) => {
    db.query(query, (err, rows) => {
      if (err) {
        reject(err);
      }
      resolve(rows);
    });
  });
}

function update(firstName, lastName, birth, country, id) {
  const query = `UPDATE tbl_user SET user_first_name = '${firstName}', user_last_name = '${lastName}', user_birth = '${birth}', user_country = '${country}' WHERE user_id = ${id}`;
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
  const query = `DELETE FROM tbl_user WHERE user_id = ${id}`;
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

function insert(firstName, lastName, birth, country) {
  const query = `INSERT INTO tbl_user (user_first_name, user_last_name, user_birth, user_country) VALUES ('${firstName}', '${lastName}', '${birth}', '${country}')`;
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
