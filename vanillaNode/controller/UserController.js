const model = require("../model/UserModel");

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
      const { user_first_name, user_last_name, user_birth, user_country } =
        JSON.parse(body);
      const user = {
        user_first_name,
        user_last_name,
        user_birth,
        user_country,
      };

      model.insert(user_first_name, user_last_name, user_birth, user_country);
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
      const { user_first_name, user_last_name, user_birth, user_country } =
        JSON.parse(body);
      const user = {
        user_first_name,
        user_last_name,
        user_birth,
        user_country,
      };

      model.update(
        user_first_name,
        user_last_name,
        user_birth,
        user_country,
        id
      );
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
