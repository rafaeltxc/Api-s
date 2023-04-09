const model = require("../model/AccountModel");

async function findAll(req, res) {
  try {
    const data = await model.getAll();

    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(data, null, 2));
  } catch (err) {
    throw err;
  }
}

async function findById(id, req, res) {
  try {
    const data = await model.getById(id);

    res.writeHead(200, { "Content-Type": "application/json" });
    res.end(JSON.stringify(data, null, 2));
  } catch (err) {
    throw err;
  }
}

function insert(req, res) {
  try {
    let body = "";
    req.on("data", (chunk) => {
      body += chunk;
    });

    req.on("end", async () => {
      const {
        account_total_money,
        fk_tbl_user_tbl_account,
        fk_tbl_bank_tbl_account,
      } = JSON.parse(body);
      const user = {
        account_total_money,
        fk_tbl_user_tbl_account,
        fk_tbl_bank_tbl_account,
      };

      model.insert(
        account_total_money,
        fk_tbl_user_tbl_account,
        fk_tbl_bank_tbl_account
      );
      res.writeHead(201, { "Content-Type": "application/json" });
      res.end(JSON.stringify(user));
    });
  } catch (err) {
    throw err;
  }
}

function update(id, req, res) {
  try {
    let body = "";
    req.on("data", (chunk) => {
      body += chunk;
    });

    req.on("end", async () => {
      const { account_total_money } = JSON.parse(body);
      const user = {
        account_total_money,
        id,
      };

      model.update(account_total_money, id);
      res.writeHead(200, { "Content-Type": "application/json" });
      res.end(JSON.stringify(user));
    });
  } catch (err) {
    throw err;
  }
}

function deletion(id, req, res) {
  try {
    model.deletetion(id);

    res.writeHead(200, { "Content-Type": "application/json" });
    res.end("data deleted with success");
  } catch (err) {
    throw err;
  }
}

module.exports = {
  findAll,
  findById,
  insert,
  update,
  deletion,
};
