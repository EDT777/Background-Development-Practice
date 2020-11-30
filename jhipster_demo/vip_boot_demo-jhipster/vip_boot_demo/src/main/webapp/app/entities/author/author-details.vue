<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="author">
                <h2 class="jh-entity-heading"><span v-text="$t('vip1App.author.detail.title')">Author</span> {{author.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('vip1App.author.name')">Name</span>
                    </dt>
                    <dd>
                        <span>{{author.name}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.author.pct')">Pct</span>
                    </dt>
                    <dd>
                        <span>{{author.pct}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.author.valid')">Valid</span>
                    </dt>
                    <dd>
                        <span>{{author.valid}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.author.createDate')">Create Date</span>
                    </dt>
                    <dd>
                        <span v-if="author.createDate">{{$d(Date.parse(author.createDate), 'long') }}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('vip1App.author.level')">Level</span>
                    </dt>
                    <dd>
                        <span>{{author.level}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="author.id" :to="{name: 'AuthorEdit', params: {authorId: author.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./author-details.component.ts">
</script>
