const http = require("http");
const userController = require("./controller/UserController");
const bankController = require("./controller/BankController");
const accController = require("./controller/AccountController");

const server = http.createServer((req, res) => {
  switch (req.url) {
    case "/api/user":
      if (req.method === "GET") {
        userController.findAll(req, res);
      } else if (req.method === "POST") {
        userController.insert(req, res);
      }
      break;
    case "/api/user/" + req.url.split("/")[3]:
      const userId = req.url.split("/")[3];

      if (req.method === "GET") {
        userController.findById(userId, req, res);
      } else if (req.method === "PUT") {
        userController.update(userId, req, res);
      } else if (req.method === "DELETE") {
        userController.deletion(userId, req, res);
      }
      break;
    case "/api/bank":
      if (req.method === "GET") {
        bankController.findAll(req, res);
      } else if (req.method === "POST") {
        bankController.insert(req, res);
      }
      break;
    case "/api/bank/" + req.url.split("/")[3]:
      const bankId = req.url.split("/")[3];

      if (req.method === "GET") {
        bankController.findById(bankId, req, res);
      } else if (req.method === "PUT") {
        bankController.update(bankId, req, res);
      } else if (req.method === "DELETE") {
        bankController.deletion(bankId, req, res);
      }
      break;
    case "/api/account":
      if (req.method === "GET") {
        accController.findAll(req, res);
      } else if (req.method === "POST") {
        accController.insert(req, res);
      }
      break;
    case "/api/account/" + req.url.split("/")[3]:
      const accountId = req.url.split("/")[3];

      if (req.method === "GET") {
        accController.findById(accountId, req, res);
      } else if (req.method === "PUT") {
        accController.update(accountId, req, res);
      } else if (req.method === "DELETE") {
        accController.deletion(accountId, req, res);
      }
      break;
    default:
      res.writeHead(400, { "Content-Type": "application/json" });
      res.end("Page not found");
  }
});

server.listen(8080, "localhost", (err) => {
  if (err) throw err;
  console.log("Server running at http://localhost:8080");
});
