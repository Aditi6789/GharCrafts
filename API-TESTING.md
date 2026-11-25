# API quick test (optional)

Start the application and use Postman or curl. These requests assume the server is at `http://localhost:8080`.

Register:
```bash
curl -i -c cookies.txt -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Demo User","email":"demo@example.com","password":"demo123"}'
```

List products:
```bash
curl http://localhost:8080/api/products
```

Add the first product to the cart:
```bash
curl -i -b cookies.txt -X POST http://localhost:8080/api/cart/items \
  -H "Content-Type: application/json" \
  -d '{"productId":1,"quantity":1}'
```

View cart:
```bash
curl -b cookies.txt http://localhost:8080/api/cart
```

Place a demo order:
```bash
curl -i -b cookies.txt -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"shippingAddress":"House 10, Sagar, Madhya Pradesh, 470001"}'
```

This is a demo checkout only; no payment is taken.
