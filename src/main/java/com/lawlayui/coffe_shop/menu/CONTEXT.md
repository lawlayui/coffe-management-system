The context focuses on the catalog. This context does not publish any events. A `MenuItem` is created if the recipe and branch already exist and are valid. The `MenuItem` is deleted when the branch or recipe is deleted.

**1. Events**
**1.1 Listeners**
- RecipeDeleted
- BranchDeleted
- InventoryQuantityAdjusted

**2. Features**
- Updating the coffee availability status (triggered by the `InventoryQuantityAdjusted` event)
- Updating the price (triggered by the user via `PATCH /api/v1/menu/item/{id}`)
- Creating a `MenuItem` (triggered by the user via `POST /api/v1/menu/item`)

**3. Pending Tasks**
- Create the "create" use case and its adapter
- Create the data retrieval use case (based on `BranchId`) and its adapter
- Create a final `univ-id` field with a getter
- Create a listener for `InventoryQuantityAdjusted`