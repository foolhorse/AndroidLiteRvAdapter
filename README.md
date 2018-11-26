# AndroidLiteRvAdapter

`LiteRvAdapter` provide a simple way to use RecyclerView in most simple situation.

## Usage

### Dependencies

```groovy
compile 'me.machao.litervadapter:litervadapter:1.0.0'
```

### TextRvAdapter

TextRvAdapter support a simple text list `RecyclerView`.

```Java
List<String> textList = new ArrayList<>();
recyclerView.setAdapter(new TextRvAdapter(textList));
```

That's all. or, use an attribute in entity:

```Java
class Pojo {
    public String name;
}
List<Pojo> pojoList = new ArrayList<>();
rv.setAdapter(new TextRvAdapter(pojoList,"name"));
``

And, change certain `TextView` attributes directly

```Java
textRvAdapter.color(0xFF000000);
textRvAdapter.size(32);
textRvAdapter.padding(16,16,16,16);
```

### LiteModel

let your data class implements the interface `LiteModel`, override the bind method, this method will be called when `RecyclerView.Adapter.onBindViewHolder` called, the `ViewCache` argument carried the item view's information, you can use `get(viewId)` to find the child view in item view.

new a LiteRvAdapter by the data list and item view layout res.
```Java
public class Item implements LiteModel {
    public String text ;

    @Override
    public void bind(ViewCache c) {
        ((TextView)c.get(R.id.tv)).setText(text);
    }
}

List<Item> items = new ArrayList<>();
recyclerView.setAdapter(new LiteRvAdapter(R.layout.item_1, items));
```

### LiteLayoutModel

basically, LiteLayoutModel is the same as LiteModel, but the layout res is returned by `getLayoutRes()` in the implementation of LiteLayoutModel.
```
class LayoutItem implements LiteLayoutModel {
    public String text;

    @Override
    public int getLayoutRes() {
        return R.layout.litervadapter_item_text;
    }

    @Override
    public void bind(ViewCache c) {
        TextView tv = c.get(R.id.tv);
        tv.setText(text);

    }
}

List<LayoutItem> items = new ArrayList<>();
recyclerView.setAdapter(new LiteRvAdapter(items));
```