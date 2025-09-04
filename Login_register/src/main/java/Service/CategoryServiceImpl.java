package Service;

import java.io.File;
import java.util.List;

import Dao.CategoryDao;
import Dao.CategoryDaoImpl;
import Model.Category;
import Service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    private static final String UPLOAD_DIR = "E:/upload/category/";

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category newCategory) {
        Category oldCategory = categoryDao.get(newCategory.getCateId());
        if (oldCategory != null) {
            oldCategory.setCateName(newCategory.getCateName());
            oldCategory.setUserId(newCategory.getUserId());

            // Nếu có upload ảnh mới thì xóa ảnh cũ và gán ảnh mới
            if (newCategory.getIcons() != null && !newCategory.getIcons().isEmpty()) {
                String oldFileName = oldCategory.getIcons();
                if (oldFileName != null) {
                    File oldFile = new File(UPLOAD_DIR + oldFileName);
                    if (oldFile.exists()) {
                        oldFile.delete();
                    }
                }
                oldCategory.setIcons(newCategory.getIcons());
            }

            categoryDao.edit(oldCategory);
        }
    }

    @Override
    public void delete(int id) {
        Category category = categoryDao.get(id);
        if (category != null) {

            if (category.getIcons() != null) {
                File file = new File(UPLOAD_DIR + category.getIcons());
                if (file.exists()) {
                    file.delete();
                }
            }
            categoryDao.delete(id);
        }
    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}

