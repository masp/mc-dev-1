package net.minecraft.server;

import java.util.Random;

public class PathfinderGoalFleeSun extends PathfinderGoal {

    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private float e;
    private World f;

    public PathfinderGoalFleeSun(EntityCreature entitycreature, float f) {
        this.a = entitycreature;
        this.e = f;
        this.f = entitycreature.world;
        this.a(1);
    }

    public boolean a() {
        if (!this.f.s()) {
            return false;
        } else if (!this.a.isBurning()) {
            return false;
        } else if (!this.f.j(MathHelper.floor(this.a.locX), (int) this.a.boundingBox.b, MathHelper.floor(this.a.locZ))) {
            return false;
        } else {
            Vec3D vec3d = this.f();

            if (vec3d == null) {
                return false;
            } else {
                this.b = vec3d.a;
                this.c = vec3d.b;
                this.d = vec3d.c;
                return true;
            }
        }
    }

    public boolean b() {
        return !this.a.getNavigation().f();
    }

    public void e() {
        this.a.getNavigation().a(this.b, this.c, this.d, this.e);
    }

    private Vec3D f() {
        Random random = this.a.au();

        for (int i = 0; i < 10; ++i) {
            int j = MathHelper.floor(this.a.locX + (double) random.nextInt(20) - 10.0D);
            int k = MathHelper.floor(this.a.boundingBox.b + (double) random.nextInt(6) - 3.0D);
            int l = MathHelper.floor(this.a.locZ + (double) random.nextInt(20) - 10.0D);

            if (!this.f.j(j, k, l) && this.a.a(j, k, l) < 0.0F) {
                return Vec3D.a().create((double) j, (double) k, (double) l);
            }
        }

        return null;
    }
}
